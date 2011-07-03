(ns shouter.controllers.shouts
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [ring.util.response :as ring]
            [shouter.views.shouts :as view]
            [shouter.models.shout :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [params]
  (when-let [shout (:shout params)]
    (model/create shout))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" {params :params} (create params)))
