(ns shouter.models.shout
  (:use [clojure.contrib.sql :only [with-connection insert-values with-query-results]]))

(let [db-host "localhost"
      db-port "5432"
      db-name "shouter"]
  (def db {:classname "org.postgresql.Driver"
           :subprotocol "postgresql"
           :subname (str "//" db-host ":" db-port "/" db-name)}))

(defn all
  []
  (with-connection db
    (with-query-results results
      ["select * from shouts order by id desc"]
      (into [] results))))

(defn create
  [shout]
  (with-connection db
    (insert-values :shouts [:body] [shout])))
