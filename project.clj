(defproject shouter "1.0.0-SNAPSHOT"
  :description "SHOUT from the webtops"
  :dependencies [[org.clojure/clojure "1.2.1"]
                 [org.clojure/java.jdbc "0.0.3-SNAPSHOT"]
                 [postgresql/postgresql "8.4-702.jdbc4"]
                 [ring/ring-jetty-adapter "0.3.9"]
                 [compojure "0.6.3"]
                 [hiccup "0.3.5"]]
  :dev-dependencies [[swank-clojure "1.2.1"]]
  :main shouter.main
  :repositories {"sonatype-oss-public" "https://oss.sonatype.org/content/groups/public/"})
