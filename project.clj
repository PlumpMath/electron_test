(defproject electron_test "0.1.0-SNAPSHOT"
  :description "A simple example to use cljs with electron"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.28"]]

  :plugins [[lein-cljsbuild "1.0.6"]]

  :cljsbuild
  {:builds [{:source-paths ["src"]
             :compiler {:output-to "app/main.js"
                        :source-map "app/main.js.map"
                        :output-dir "app"
                        :optimizations :simple
                        :pretty-print false
                        }}]})
