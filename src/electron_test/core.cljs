(ns electron-test.core)

(def app            (js/require "app"))
(def browser-window (js/require "browser-window"))

(.start (js/require "crash-reporter"))

(def main-window (atom nil))

(.on app "window-all-closed"
     (fn []
       (when-not (= js/process.platform "darwin")
         (.quit app))
       ))

(.on app "ready"
     (fn []
       (reset! main-window (browser-window.
                            (clj->js {:width 800, :height 600})))

       (.loadUrl @main-window (str "file://" js/__dirname "/index.html"))

       (.openDevTools @main-window)

       (.on @main-window "closed"
            #(reset! main-window nil))

       ))
