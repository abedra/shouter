(defproject shouter "1.0.0-SNAPSHOT"
  :description "SHOUT from the webtops"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/java.jdbc "0.1.1"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [ring/ring-jetty-adapter "1.0.0-RC1"]
                 [compojure "0.6.5"]
                 [hiccup "0.3.7"]]
  :main shouter.main)