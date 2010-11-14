(ns shouter.views.layout
  (:use [hiccup.core :only [html]]
        [hiccup.page-helpers :only [doctype include-css]]))

(defn application
  [title & body]
  (html
   (doctype :html5)
   [:head
    [:title title]
    (include-css "/stylesheets/screen.css")]
   [:body
    [:div {:id "header"}
     [:h1 "SHOUTER"]]
    [:div {:id "content"} body]]))
