(ns cljs-ui
  (:require
    [reagent.core :as r]
    [reagent.dom :as rdom]
    [clojure.set :as set]))

(defn slides []
  [:div#carouselExampleControls.carousel.carousel-dark.slide
   [:div.carousel-inner
    [:div.carousel-item
     [:svg.bd-placeholder-img.bd-placeholder-img-lg.d-block.w-100
      {:width "800" :height "100vh" :xmlns "http://www.w3.org/2000/svg" :role "img" :preserveAspectRatio "xMidYMid slice" :focusable "false"}
      [:title "Placeholder"]
      [:rect {:width "100%" :height "100%" :fill "#ffe7e5"}]
      [:text {:x "50%" :y "50%" :fill "#555" :dy ".3em"} "nbb Lambdas"]
      ]]
    [:div.carousel-item
     [:svg.bd-placeholder-img.bd-placeholder-img-lg.d-block.w-100
      {:width "800" :height "100vh" :xmlns "http://www.w3.org/2000/svg" :role "img" :preserveAspectRatio "xMidYMid slice" :focusable "false"}
      [:title "Placeholder"]
      [:rect {:width "100%" :height "100%" :fill "#ffe7e5"}]
      [:text {:x "50%" :y "25%" :fill "#555" :dy ".3em"} "nbb in brief"]
      [:text {:x "50%" :y "50%" :fill "#555" :dy ".3em"} "nbb local dev"]
      [:text {:x "50%" :y "75%" :fill "#555" :dy ".3em"} "nbb Lambdas"]
      ]]
    [:div.carousel-item.active
     [:svg.bd-placeholder-img.bd-placeholder-img-lg.d-block.w-100
      {:width "800" :height "100vh" :xmlns "http://www.w3.org/2000/svg" :role "img" :preserveAspectRatio "xMidYMid slice" :focusable "false"}
      [:title "nbb in brief"]
      [:rect {:width "100%" :height "100%" :fill "#ffe7e5"}]
      [:text {:x "50%" :y "10%" :fill "#000" :dy ".3em"} "nbb in brief"]
      [:text {:x "50%" :y "35%" :fill "#555" :dy ".3em"} "CLJS interpreter for nodejs \uD83D\uDDE3️"]
      [:text {:x "50%" :y "50%" :fill "#555" :dy ".3em"} "No packaging required \uD83E\uDDE0"]
      [:text {:x "50%" :y "65%" :fill "#555" :dy ".3em"} "SCI is used to do the heavy lifting \uD83C\uDFCB️\u200D♀️"]
      ]
     [:div.carousel-caption.d-none.d-md-block
      [:h3 "nodejs starts fast and has a prodigious standard library"]
      [:h5 "A small suite of curated packages are shipped with nbb including promesa, cljs-bean"]]]]
   [:button.carousel-control-prev {:type "button" :data-bs-target "#carouselExampleControls" :data-bs-slide "prev"}
    [:span.carousel-control-prev-icon]
    [:span.visually-hidden "Previous"]]
   [:button.carousel-control-next {:type "button" :data-bs-target "#carouselExampleControls" :data-bs-slide "next"}
    [:span.carousel-control-next-icon]
    [:span.visually-hidden "Next"]]])


(defn home-page
  []
  [:div.m-0.border-0 [slides]])


(rdom/render [home-page] (js/document.getElementById "app"))
