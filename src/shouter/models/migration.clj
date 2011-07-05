(ns shouter.models.migration
  (:use [shouter.models.base :only (db)])
  (:require [clojure.java.jdbc :as sql]))

(defn create-shouts []
  (sql/with-connection db
    (sql/create-table :shouts
                      [:id :serial "PRIMARY KEY"]
                      [:body :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))

(defn -main []
  (print "Migrating database...") (flush)
  (create-shouts)
  (println " done"))
