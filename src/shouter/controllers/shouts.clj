(ns shouter.controllers.shouts
  (:use [ring.util.response :only [redirect]]
        [compojure.core :only [defroutes GET POST]])
  (:require [shouter.views.shouts :as view]
            [shouter.models.shout :as model]))

(defn index
  []
  (view/index (model/all)))

(defn create
  [params]
  (model/create (:shout params))
  (redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" {params :params} (create params)))
