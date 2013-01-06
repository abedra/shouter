(ns shouter.controllers.shouts
  (:use [compojure.core :only (defroutes GET POST)])
  (:require [clojure.string :as str]
            [ring.util.response :as ring]
            [shouter.views.shouts :as view]
            [shouter.models.shout :as model]))

(defn index []
  (view/index (model/all)))

(defn create
  [shout]
  (when-not (str/blank? shout)
    (model/create shout))
  (ring/redirect "/"))

(defroutes routes
  (GET  "/" [] (index))
  (POST "/" [shout] (create shout)))
