;; # Ex52: Creating Your Own Time Service
;;
;; - Build a minimal web server that returns the current time as JSON: { "currentTime": "2050-01-24 15:06:26" }.
;; - Build a client that fetches this JSON, parses it, and displays the time in a readable format.
;; - Server must set Content-Type: application/json.
;; - Keep server code minimal.

(ns ex52.server
  (:require [org.httpkit.server :as http]
            [ring.util.response :as response]
            [cheshire.core :as json]
            [java-time.api :as jt]))

(defn now-string []
  (jt/format "uuuu-MM-dd HH:mm:ss"
             (jt/zoned-date-time (jt/instant) (jt/zone-id "UTC"))))

(defn handler [req]
  (if (and (= (:request-method req) :get)
           (= (:uri req) "/ex52/time"))
    (-> {:currentTime (now-string)}
        json/generate-string
        response/response
        (response/content-type "application/json"))
    (response/not-found "Not Found")))

(defn -main []
  (http/run-server handler {:port 8080}))
