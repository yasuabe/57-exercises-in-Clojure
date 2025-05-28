(ns ex52.server-test
  (:require [clojure.test :refer [deftest is testing]]
            [ex52.server :refer [handler]]
            [ring.mock.request :as mock]))

(deftest test-handler
  (testing "Valid /ex52/time request"
    (let [response (handler (mock/request :get "/ex52/time"))]
      (is (= 200 (:status response)))
      (is (= "application/json" (get-in response [:headers "Content-Type"])))
      (is (some? (re-find #"\d{4}-\d{2}-\d{2} \d{2}:\d{2}:\d{2}" (:body response))))))

  (testing "Invalid request"
    (let [response (handler (mock/request :get "/invalid"))]
      (is (= 404 (:status response))))))

