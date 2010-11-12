(ns shouter.views.shouts
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype]]
        [hiccup.form-helpers :only [form-to label text-area submit-button]]))

(defn shout-form
  []
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
  (html
   (doctype :html5)
   [:head
    [:title "Shouter"]]
   [:body
    [:div {:id "content"}
     (shout-form)
     (display-shouts shouts)]]))
