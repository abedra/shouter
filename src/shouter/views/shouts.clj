(ns shouter.views.shouts
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]])
  (:require [shouter.views.layout :as layout]))

(defn shout-form []
  [:div {:id "shout-form" :class "sixteen columns alpha omega"}
   (form-to [:post "/"]
            (label "shout" "What do you want to SHOUT?") 
            (text-area "shout")
            (submit-button "SHOUT!"))])

(defn display-shout [shout]
  [:h2 {:class "shout"} (:body shout)])

(defn display-shouts [shouts]
  [:div {:id "shouts sixteen columns alpha omega"}
   (map
    (fn [shout] (display-shout shout))
    shouts)])

(defn index [shouts]
  (layout/common "SHOUTER"
                 (shout-form)
                 [:div {:class "clear"}]
                 (display-shouts shouts)))
