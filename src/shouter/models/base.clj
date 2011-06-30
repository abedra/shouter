(ns shouter.models.base
  (:require [clojure.java.jdbc :as sql]))

(let [db-host "localhost"
      db-port "5432"
      db-name "shouter"]
  (def db {:classname "org.postgresql.Driver"
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)}))

(defn create-shouter-db []
  (sql/with-connection db
    (sql/create-table :shouts
                      [:id :serial "PRIMARY KEY"]
                      [:body :varchar "NOT NULL"]
                      [:created_at :timestamp "NOT NULL" "DEFAULT CURRENT_TIMESTAMP"])))
