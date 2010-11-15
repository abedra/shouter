(ns shouter.views.shouts
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [shouter.views.layout :as layout]))

(defn shout-form
  []
  [:div {:id "shout-form"}]
  (form-to [:post "/"]
           (label "shout" "What do you want to SHOUT?") [:br]
           (text-area "shout")
           (submit-button "SHOUT!")))

(defn display-shouts
  [shouts]
  [:div {:id "shouts"}
   (map
    (fn [shout] [:div {:class "shout"} (:body shout)])
    shouts)])

(defn index
  [shouts]
  (layout/common "SHOUTER"
                 (shout-form)
                 (display-shouts shouts)))
