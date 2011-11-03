(ns shouter.models.migration
  (:require [clojure.java.jdbc :as sql]))

(defn create-shouts []
  (sql/with-connection (System/getenv "DATABASE_URL")
    (sql/create-table :shouts
                      [:id :serial "PRIMARY KEY"]
                      [:body :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn -main []
  (print "Creating database structure...") (flush)
  (create-shouts)
  (println " done"))
