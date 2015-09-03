(defproject shouter "0.0.2"
  :description "Shouter app"
  :url "https://github.com/technomancy/shouter"
  :min-lein-version "2.0.0"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/java.jdbc "0.4.1"]
                 [org.postgresql/postgresql "9.4-1201-jdbc41"]
                 [ring/ring-jetty-adapter "1.4.0"]
                 [compojure "1.4.0"]
                 [ring/ring-defaults "0.1.2"]
                 [hiccup "1.0.5"]]
  :main ^:skip-aot shouter.core
  :uberjar-name "shouter-standalone.jar"
  :plugins [[lein-ring "0.8.13"]]
  :ring {:handler shouter.web/application
         :init shouter.models.migration/migrate}
  :profiles {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                                  [ring-mock "0.1.5"]]}
             :uberjar {:aot :all}})
