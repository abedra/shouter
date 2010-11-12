(ns shouter.models.base
  (:use [clojure.contrib.sql :only [with-connection create-table]]))

(let [db-host "localhost"
      db-port "5432"
      db-name "shouter"]
  (def db {:classname "org.postgresql.Driver"
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)}))

(defn create-shouter-db
  []
  (with-connection db
    (create-table :shouts
                  [:id :serial "PRIMARY KEY"]
                  [:body :varchar "NOT NULL"]
                  [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))
