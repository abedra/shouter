(ns shouter.main
  (:use [clojure.pprint]
        [clojure.contrib.logging :only [debug]]
        [ring.adapter.jetty :only [run-jetty]]
	[ring.middleware.params :only (wrap-params)]        
	[ring.middleware.keyword-params :only [wrap-keyword-params]]
        [compojure.core :only [defroutes]])
  (:require [compojure.route :as route]
            [shouter.controllers.shouts]))

(def static-file-regex
     #".*\.(css|js|png|jpg|gif|ico)$")

(defn wrap-logging [handler prefix]
  (fn [request]
    (if (re-find static-file-regex (:uri request))
      (debug (str prefix (:uri request)))
      (debug (str prefix " " (:request-method request) " " (:uri request)
		  "\n\tParameters: " (with-out-str (pprint (:params request))))))
    (handler request)))

(defroutes routes
  shouter.controllers.shouts/routes
  (route/files "/")
  (route/not-found "Not Found"))

(def application (-> routes
                     (wrap-logging "")
                     wrap-keyword-params
                     wrap-params))

(defn start
  []
  (run-jetty (var application) {:port 8080
                                :join? false}))

(defn -main [] (start))
