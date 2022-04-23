package com.fluntoo.zenberry.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class CountryList {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    @SerializedName("states")
    @Expose
    private List<Example.State> states = null;


    public List<Example.State> getStates() {
        return states;
    }

    public void setStates(List<Example.State> states) {
        this.states = states;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }


    public class Example {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("name")
        @Expose
        private String name;
        @SerializedName("iso3")
        @Expose
        private String iso3;
        @SerializedName("iso2")
        @Expose
        private String iso2;
        @SerializedName("numeric_code")
        @Expose
        private String numericCode;
        @SerializedName("phone_code")
        @Expose
        private String phoneCode;
        @SerializedName("capital")
        @Expose
        private String capital;
        @SerializedName("currency")
        @Expose
        private String currency;
        @SerializedName("currency_name")
        @Expose
        private String currencyName;
        @SerializedName("currency_symbol")
        @Expose
        private String currencySymbol;
        @SerializedName("tld")
        @Expose
        private String tld;
        @SerializedName("native")
        @Expose
        private String _native;
        @SerializedName("region")
        @Expose
        private String region;
        @SerializedName("subregion")
        @Expose
        private String subregion;
        @SerializedName("timezones")
        @Expose
        private List<Timezone> timezones = null;
        @SerializedName("translations")
        @Expose
        private Timezone.Translations translations;
        @SerializedName("latitude")
        @Expose
        private String latitude;
        @SerializedName("longitude")
        @Expose
        private String longitude;
        @SerializedName("emoji")
        @Expose
        private String emoji;
        @SerializedName("emojiU")
        @Expose
        private String emojiU;
        @SerializedName("states")
        @Expose
        private List<State> states = null;

        @Override
        public String toString() {
            return "Example{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", iso3='" + iso3 + '\'' +
                    ", iso2='" + iso2 + '\'' +
                    ", numericCode='" + numericCode + '\'' +
                    ", phoneCode='" + phoneCode + '\'' +
                    ", capital='" + capital + '\'' +
                    ", currency='" + currency + '\'' +
                    ", currencyName='" + currencyName + '\'' +
                    ", currencySymbol='" + currencySymbol + '\'' +
                    ", tld='" + tld + '\'' +
                    ", _native='" + _native + '\'' +
                    ", region='" + region + '\'' +
                    ", subregion='" + subregion + '\'' +
                    ", timezones=" + timezones +
                    ", translations=" + translations +
                    ", latitude='" + latitude + '\'' +
                    ", longitude='" + longitude + '\'' +
                    ", emoji='" + emoji + '\'' +
                    ", emojiU='" + emojiU + '\'' +
                    ", states=" + states +
                    '}';
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getIso3() {
            return iso3;
        }

        public void setIso3(String iso3) {
            this.iso3 = iso3;
        }

        public String getIso2() {
            return iso2;
        }

        public void setIso2(String iso2) {
            this.iso2 = iso2;
        }

        public String getNumericCode() {
            return numericCode;
        }

        public void setNumericCode(String numericCode) {
            this.numericCode = numericCode;
        }

        public String getPhoneCode() {
            return phoneCode;
        }

        public void setPhoneCode(String phoneCode) {
            this.phoneCode = phoneCode;
        }

        public String getCapital() {
            return capital;
        }

        public void setCapital(String capital) {
            this.capital = capital;
        }

        public String getCurrency() {
            return currency;
        }

        public void setCurrency(String currency) {
            this.currency = currency;
        }

        public String getCurrencyName() {
            return currencyName;
        }

        public void setCurrencyName(String currencyName) {
            this.currencyName = currencyName;
        }

        public String getCurrencySymbol() {
            return currencySymbol;
        }

        public void setCurrencySymbol(String currencySymbol) {
            this.currencySymbol = currencySymbol;
        }

        public String getTld() {
            return tld;
        }

        public void setTld(String tld) {
            this.tld = tld;
        }

        public String getNative() {
            return _native;
        }

        public void setNative(String _native) {
            this._native = _native;
        }

        public String getRegion() {
            return region;
        }

        public void setRegion(String region) {
            this.region = region;
        }

        public String getSubregion() {
            return subregion;
        }

        public void setSubregion(String subregion) {
            this.subregion = subregion;
        }

        public List<Timezone> getTimezones() {
            return timezones;
        }

        public void setTimezones(List<Timezone> timezones) {
            this.timezones = timezones;
        }

        public Timezone.Translations getTranslations() {
            return translations;
        }

        public void setTranslations(Timezone.Translations translations) {
            this.translations = translations;
        }

        public String getLatitude() {
            return latitude;
        }

        public void setLatitude(String latitude) {
            this.latitude = latitude;
        }

        public String getLongitude() {
            return longitude;
        }

        public void setLongitude(String longitude) {
            this.longitude = longitude;
        }

        public String getEmoji() {
            return emoji;
        }

        public void setEmoji(String emoji) {
            this.emoji = emoji;
        }

        public String getEmojiU() {
            return emojiU;
        }

        public void setEmojiU(String emojiU) {
            this.emojiU = emojiU;
        }

        public List<State> getStates() {
            return states;
        }

        public void setStates(List<State> states) {
            this.states = states;
        }


        public class State {

            @SerializedName("id")
            @Expose
            private Integer id;
            @SerializedName("name")
            @Expose
            private String name;
            @SerializedName("state_code")
            @Expose
            private String stateCode;
            @SerializedName("latitude")
            @Expose
            private String latitude;
            @SerializedName("longitude")
            @Expose
            private String longitude;
            @SerializedName("type")
            @Expose
            private Object type;
          /*  @SerializedName("cities")
            @Expose
            private List<City> cities = null;*/

            public Integer getId() {
                return id;
            }

            public void setId(Integer id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getStateCode() {
                return stateCode;
            }

            public void setStateCode(String stateCode) {
                this.stateCode = stateCode;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
            }

            public String getLongitude() {
                return longitude;
            }

            public void setLongitude(String longitude) {
                this.longitude = longitude;
            }

            public Object getType() {
                return type;
            }

            public void setType(Object type) {
                this.type = type;
            }

            @Override
            public String toString() {
                return "State{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", stateCode='" + stateCode + '\'' +
                        ", latitude='" + latitude + '\'' +
                        ", longitude='" + longitude + '\'' +
                        ", type=" + type +
                        '}';
            }


//           public List<City> getCities() {
//                return cities;
//            }
//
//            public void setCities(List<City> cities) {
//                this.cities = cities;
//            }

        }

        public class Timezone {

            @SerializedName("zoneName")
            @Expose
            private String zoneName;
            @SerializedName("gmtOffset")
            @Expose
            private Integer gmtOffset;
            @SerializedName("gmtOffsetName")
            @Expose
            private String gmtOffsetName;
            @SerializedName("abbreviation")
            @Expose
            private String abbreviation;
            @SerializedName("tzName")
            @Expose
            private String tzName;

            public String getZoneName() {
                return zoneName;
            }

            public void setZoneName(String zoneName) {
                this.zoneName = zoneName;
            }

            public Integer getGmtOffset() {
                return gmtOffset;
            }

            public void setGmtOffset(Integer gmtOffset) {
                this.gmtOffset = gmtOffset;
            }

            public String getGmtOffsetName() {
                return gmtOffsetName;
            }

            public void setGmtOffsetName(String gmtOffsetName) {
                this.gmtOffsetName = gmtOffsetName;
            }

            public String getAbbreviation() {
                return abbreviation;
            }

            public void setAbbreviation(String abbreviation) {
                this.abbreviation = abbreviation;
            }

            public String getTzName() {
                return tzName;
            }

            public void setTzName(String tzName) {
                this.tzName = tzName;
            }


            public class Translations {

                @SerializedName("kr")
                @Expose
                private String kr;
                @SerializedName("br")
                @Expose
                private String br;
                @SerializedName("pt")
                @Expose
                private String pt;
                @SerializedName("nl")
                @Expose
                private String nl;
                @SerializedName("hr")
                @Expose
                private String hr;
                @SerializedName("fa")
                @Expose
                private String fa;
                @SerializedName("de")
                @Expose
                private String de;
                @SerializedName("es")
                @Expose
                private String es;
                @SerializedName("fr")
                @Expose
                private String fr;
                @SerializedName("ja")
                @Expose
                private String ja;
                @SerializedName("it")
                @Expose
                private String it;
                @SerializedName("cn")
                @Expose
                private String cn;

                public String getKr() {
                    return kr;
                }

                public void setKr(String kr) {
                    this.kr = kr;
                }

                public String getBr() {
                    return br;
                }

                public void setBr(String br) {
                    this.br = br;
                }

                public String getPt() {
                    return pt;
                }

                public void setPt(String pt) {
                    this.pt = pt;
                }

                public String getNl() {
                    return nl;
                }

                public void setNl(String nl) {
                    this.nl = nl;
                }

                public String getHr() {
                    return hr;
                }

                public void setHr(String hr) {
                    this.hr = hr;
                }

                public String getFa() {
                    return fa;
                }

                public void setFa(String fa) {
                    this.fa = fa;
                }

                public String getDe() {
                    return de;
                }

                public void setDe(String de) {
                    this.de = de;
                }

                public String getEs() {
                    return es;
                }

                public void setEs(String es) {
                    this.es = es;
                }

                public String getFr() {
                    return fr;
                }

                public void setFr(String fr) {
                    this.fr = fr;
                }

                public String getJa() {
                    return ja;
                }

                public void setJa(String ja) {
                    this.ja = ja;
                }

                public String getIt() {
                    return it;
                }

                public void setIt(String it) {
                    this.it = it;
                }

                public String getCn() {
                    return cn;
                }

                public void setCn(String cn) {
                    this.cn = cn;
                }

            }
        }
    }
}




//    @SerializedName("id")
//    @Expose
//    private Integer id;
//    @SerializedName("name")
//    @Expose
//    private String name;
//    @SerializedName("latitude")
//    @Expose
//    private String latitude;
//    @SerializedName("longitude")
//    @Expose
//    private String longitude;
//
//    public Integer getId() {
//        return id;
//    }
//
//    public void setId(Integer id) {
//        this.id = id;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLatitude() {
//        return latitude;
//    }
//
//    public void setLatitude(String latitude) {
//        this.latitude = latitude;
//    }
//
//    public String getLongitude() {
//        return longitude;
//    }
//
//    public void setLongitude(String longitude) {
//        this.longitude = longitude;
//    }
//
//
//    public class Example {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("iso3")
//        @Expose
//        private String iso3;
//        @SerializedName("iso2")
//        @Expose
//        private String iso2;
//        @SerializedName("numeric_code")
//        @Expose
//        private String numericCode;
//        @SerializedName("phone_code")
//        @Expose
//        private String phoneCode;
//        @SerializedName("capital")
//        @Expose
//        private String capital;
//        @SerializedName("currency")
//        @Expose
//        private String currency;
//        @SerializedName("currency_name")
//        @Expose
//        private String currencyName;
//        @SerializedName("currency_symbol")
//        @Expose
//        private String currencySymbol;
//        @SerializedName("tld")
//        @Expose
//        private String tld;
//        @SerializedName("native")
//        @Expose
//        private String _native;
//        @SerializedName("region")
//        @Expose
//        private String region;
//        @SerializedName("subregion")
//        @Expose
//        private String subregion;
//        @SerializedName("timezones")
//        @Expose
//        private List<Timezone> timezones = null;
//        @SerializedName("translations")
//        @Expose
//        private Timezone.Translations translations;
//        @SerializedName("latitude")
//        @Expose
//        private String latitude;
//        @SerializedName("longitude")
//        @Expose
//        private String longitude;
//        @SerializedName("emoji")
//        @Expose
//        private String emoji;
//        @SerializedName("emojiU")
//        @Expose
//        private String emojiU;
//        @SerializedName("states")
//        @Expose
//        private List<State> states = null;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getIso3() {
//            return iso3;
//        }
//
//        public void setIso3(String iso3) {
//            this.iso3 = iso3;
//        }
//
//        public String getIso2() {
//            return iso2;
//        }
//
//        public void setIso2(String iso2) {
//            this.iso2 = iso2;
//        }
//
//        public String getNumericCode() {
//            return numericCode;
//        }
//
//        public void setNumericCode(String numericCode) {
//            this.numericCode = numericCode;
//        }
//
//        public String getPhoneCode() {
//            return phoneCode;
//        }
//
//        public void setPhoneCode(String phoneCode) {
//            this.phoneCode = phoneCode;
//        }
//
//        public String getCapital() {
//            return capital;
//        }
//
//        public void setCapital(String capital) {
//            this.capital = capital;
//        }
//
//        public String getCurrency() {
//            return currency;
//        }
//
//        public void setCurrency(String currency) {
//            this.currency = currency;
//        }
//
//        public String getCurrencyName() {
//            return currencyName;
//        }
//
//        public void setCurrencyName(String currencyName) {
//            this.currencyName = currencyName;
//        }
//
//        public String getCurrencySymbol() {
//            return currencySymbol;
//        }
//
//        public void setCurrencySymbol(String currencySymbol) {
//            this.currencySymbol = currencySymbol;
//        }
//
//        public String getTld() {
//            return tld;
//        }
//
//        public void setTld(String tld) {
//            this.tld = tld;
//        }
//
//        public String getNative() {
//            return _native;
//        }
//
//        public void setNative(String _native) {
//            this._native = _native;
//        }
//
//        public String getRegion() {
//            return region;
//        }
//
//        public void setRegion(String region) {
//            this.region = region;
//        }
//
//        public String getSubregion() {
//            return subregion;
//        }
//
//        public void setSubregion(String subregion) {
//            this.subregion = subregion;
//        }
//
//        public List<Timezone> getTimezones() {
//            return timezones;
//        }
//
//        public void setTimezones(List<Timezone> timezones) {
//            this.timezones = timezones;
//        }
//
//        public Timezone.Translations getTranslations() {
//            return translations;
//        }
//
//        public void setTranslations(Timezone.Translations translations) {
//            this.translations = translations;
//        }
//
//        public String getLatitude() {
//            return latitude;
//        }
//
//        public void setLatitude(String latitude) {
//            this.latitude = latitude;
//        }
//
//        public String getLongitude() {
//            return longitude;
//        }
//
//        public void setLongitude(String longitude) {
//            this.longitude = longitude;
//        }
//
//        public String getEmoji() {
//            return emoji;
//        }
//
//        public void setEmoji(String emoji) {
//            this.emoji = emoji;
//        }
//
//        public String getEmojiU() {
//            return emojiU;
//        }
//
//        public void setEmojiU(String emojiU) {
//            this.emojiU = emojiU;
//        }
//
//        public List<State> getStates() {
//            return states;
//        }
//
//        public void setStates(List<State> states) {
//            this.states = states;
//        }
//
//    }
//
//    public static class State {
//
//        @SerializedName("id")
//        @Expose
//        private Integer id;
//        @SerializedName("name")
//        @Expose
//        private String name;
//        @SerializedName("state_code")
//        @Expose
//        private String stateCode;
//        @SerializedName("latitude")
//        @Expose
//        private String latitude;
//        @SerializedName("longitude")
//        @Expose
//        private String longitude;
//        @SerializedName("type")
//        @Expose
//        private Object type;
////        @SerializedName("cities")
////        @Expose
////        private List<City> cities = null;
//
//        public Integer getId() {
//            return id;
//        }
//
//        public void setId(Integer id) {
//            this.id = id;
//        }
//
//        public String getName() {
//            return name;
//        }
//
//        public void setName(String name) {
//            this.name = name;
//        }
//
//        public String getStateCode() {
//            return stateCode;
//        }
//
//        public void setStateCode(String stateCode) {
//            this.stateCode = stateCode;
//        }
//
//        public String getLatitude() {
//            return latitude;
//        }
//
//        public void setLatitude(String latitude) {
//            this.latitude = latitude;
//        }
//
//        public String getLongitude() {
//            return longitude;
//        }
//
//        public void setLongitude(String longitude) {
//            this.longitude = longitude;
//        }
//
//        public Object getType() {
//            return type;
//        }
//
//        public void setType(Object type) {
//            this.type = type;
//        }
//
////    public List<City> getCities() {
////        return cities;
////    }
////
////    public void setCities(List<City> cities) {
////        this.cities = cities;
////    }
//
//    }
//
//    public class Timezone {
//
//        @SerializedName("zoneName")
//        @Expose
//        private String zoneName;
//        @SerializedName("gmtOffset")
//        @Expose
//        private Integer gmtOffset;
//        @SerializedName("gmtOffsetName")
//        @Expose
//        private String gmtOffsetName;
//        @SerializedName("abbreviation")
//        @Expose
//        private String abbreviation;
//        @SerializedName("tzName")
//        @Expose
//        private String tzName;
//
//        public String getZoneName() {
//            return zoneName;
//        }
//
//        public void setZoneName(String zoneName) {
//            this.zoneName = zoneName;
//        }
//
//        public Integer getGmtOffset() {
//            return gmtOffset;
//        }
//
//        public void setGmtOffset(Integer gmtOffset) {
//            this.gmtOffset = gmtOffset;
//        }
//
//        public String getGmtOffsetName() {
//            return gmtOffsetName;
//        }
//
//        public void setGmtOffsetName(String gmtOffsetName) {
//            this.gmtOffsetName = gmtOffsetName;
//        }
//
//        public String getAbbreviation() {
//            return abbreviation;
//        }
//
//        public void setAbbreviation(String abbreviation) {
//            this.abbreviation = abbreviation;
//        }
//
//        public String getTzName() {
//            return tzName;
//        }
//
//        public void setTzName(String tzName) {
//            this.tzName = tzName;
//        }
//
//
//        public class Translations {
//
//            @SerializedName("kr")
//            @Expose
//            private String kr;
//            @SerializedName("br")
//            @Expose
//            private String br;
//            @SerializedName("pt")
//            @Expose
//            private String pt;
//            @SerializedName("nl")
//            @Expose
//            private String nl;
//            @SerializedName("hr")
//            @Expose
//            private String hr;
//            @SerializedName("fa")
//            @Expose
//            private String fa;
//            @SerializedName("de")
//            @Expose
//            private String de;
//            @SerializedName("es")
//            @Expose
//            private String es;
//            @SerializedName("fr")
//            @Expose
//            private String fr;
//            @SerializedName("ja")
//            @Expose
//            private String ja;
//            @SerializedName("it")
//            @Expose
//            private String it;
//            @SerializedName("cn")
//            @Expose
//            private String cn;
//
//            public String getKr() {
//                return kr;
//            }
//
//            public void setKr(String kr) {
//                this.kr = kr;
//            }
//
//            public String getBr() {
//                return br;
//            }
//
//            public void setBr(String br) {
//                this.br = br;
//            }
//
//            public String getPt() {
//                return pt;
//            }
//
//            public void setPt(String pt) {
//                this.pt = pt;
//            }
//
//            public String getNl() {
//                return nl;
//            }
//
//            public void setNl(String nl) {
//                this.nl = nl;
//            }
//
//            public String getHr() {
//                return hr;
//            }
//
//            public void setHr(String hr) {
//                this.hr = hr;
//            }
//
//            public String getFa() {
//                return fa;
//            }
//
//            public void setFa(String fa) {
//                this.fa = fa;
//            }
//
//            public String getDe() {
//                return de;
//            }
//
//            public void setDe(String de) {
//                this.de = de;
//            }
//
//            public String getEs() {
//                return es;
//            }
//
//            public void setEs(String es) {
//                this.es = es;
//            }
//
//            public String getFr() {
//                return fr;
//            }
//
//            public void setFr(String fr) {
//                this.fr = fr;
//            }
//
//            public String getJa() {
//                return ja;
//            }
//
//            public void setJa(String ja) {
//                this.ja = ja;
//            }
//
//            public String getIt() {
//                return it;
//            }
//
//            public void setIt(String it) {
//                this.it = it;
//            }
//
//            public String getCn() {
//                return cn;
//            }
//
//            public void setCn(String cn) {
//                this.cn = cn;
//            }
//
//        }
//    }
//}
//
//
