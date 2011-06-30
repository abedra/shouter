(ns shouter.main
  (:use [compojure.core :only [defroutes]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]
            [shouter.controllers.shouts]
            [shouter.views.layout :as layout]))

(defroutes routes
  shouter.controllers.shouts/routes
  (route/resources "/")
  (route/not-found (layout/four-oh-four)))

(def application (handler/site routes))

(defn start []
  (ring/run-jetty (var application) {:port 8080
                                     :join? false}))
