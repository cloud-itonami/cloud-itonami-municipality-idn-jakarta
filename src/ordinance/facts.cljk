(ns ordinance.facts
  "Municipal-ordinance compliance catalog for Jakarta -- the
  THIRTY-FOURTH municipality-level entry (see cloud-itonami-municipality-jpn-tokyo,
  -usa-washington-dc, -gbr-london, -can-toronto, -deu-berlin, -fra-paris,
  -nld-amsterdam, -esp-madrid, -kor-seoul, -ita-roma, -aus-sydney,
  -arg-buenos-aires, -fin-helsinki, -dnk-copenhagen, -nor-oslo,
  -bel-brussels, -chl-santiago, -col-bogota, -cri-san-jose,
  -bra-sao-paulo, -ury-montevideo, -zaf-cape-town, -ecu-quito,
  -swe-gothenburg, -pry-asuncion, -mex-guadalajara, -fra-lyon,
  -ind-new-delhi, -pol-warsaw, -ken-nairobi, -tha-bangkok, -are-abu-dhabi,
  -vnm-hanoi for the first thirty-three) per ADR-2607141700
  (cloud-itonami-compliance-fact-federation).

  As of this tick, Indonesia's Constitutional Court has confirmed
  Jakarta REMAINS the official capital, not Nusantara (the planned
  new capital in East Kalimantan, whose transition remains incomplete
  and is targeted only as a 'political capital' by 2028 under a 2025
  policy reclassification) -- Jakarta's status as capital here is
  current and correct, verified independently rather than assumed
  given the ongoing, actively-litigated relocation process.

  Regulation of the Governor of the Province of Special Capital
  Region of Jakarta Number 101 of 2017 (on exemption/collection of
  local tax for foreign missions) -- title/number directly confirmed
  by reading jdih.jakarta.go.id's own English-translation PDF cover
  page; the exact day/month of enactment was not found on the pages
  checked, so :enacted-date is year-only rather than guessed. Regional
  Regulation Number 4 of 2019 (amending Regional Regulation Number 3
  of 2013 on Waste Management) -- title, number, establishment date
  (23 September 2019), and promulgation date (26 September 2019) all
  directly confirmed via jdih.jakarta.go.id's own HTML regulation-detail
  page.

  An ordinance not in this table has NO spec-basis, full stop; extend
  `catalog`, do not invent an id/url/date.")

(def catalog
  "municipality-slug -> vector of ordinance entries."
  {"jakarta"
   [{:ordinance/id "jakarta.pergub-101-2017-pajak-daerah-perwakilan-asing"
     :ordinance/title "Regulation of the Governor of the Province of Special Capital Region of Jakarta Number 101 of 2017 on Exemption, Overpayment and Collection of Local Tax to Foreign Missions"
     :ordinance/municipality "jakarta"
     :ordinance/country "IDN"
     :ordinance/kind :ordinance
     :ordinance/number "Number 101 of 2017"
     :ordinance/url "https://jdih.jakarta.go.id/terjemahan/PERGUB%20DKI%20101%20TAHUN%202017%20ENGLISH.pdf"
     :ordinance/url-provenance :official-jdih-jakarta-go-id
     :ordinance/enacted-date "2017"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:taxation}}
    {:ordinance/id "jakarta.perda-4-2019-pengelolaan-sampah"
     :ordinance/title "Regional Regulation Number 4 of 2019 on Amendment to Regional Regulation Number 3 of 2013 on Waste Management"
     :ordinance/municipality "jakarta"
     :ordinance/country "IDN"
     :ordinance/kind :ordinance
     :ordinance/number "Number 4 of 2019"
     :ordinance/url "https://jdih.jakarta.go.id/dokumen/detail/3586"
     :ordinance/url-provenance :official-jdih-jakarta-go-id
     :ordinance/enacted-date "2019-09-23"
     :ordinance/retrieved-at "2026-07-16"
     :ordinance/topic #{:waste-management :environment}}]})

(defn spec-basis [muni] (get catalog muni))

(defn coverage
  ([] (coverage (keys catalog)))
  ([munis]
   (let [have (filter catalog munis)
         missing (remove catalog munis)]
     {:requested (count munis)
      :covered (count have)
      :covered-municipalities (vec (sort have))
      :missing-municipalities (vec (sort missing))
      :note (str "cloud-itonami-municipality-idn-jakarta Wave 0 (ADR-2607141700): "
                 (count (get catalog "jakarta")) " Jakarta entries seeded "
                 "with official jdih.jakarta.go.id citations. "
                 "Extend `ordinance.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [muni topic]
  (filterv #(contains? (:ordinance/topic %) topic) (spec-basis muni)))
