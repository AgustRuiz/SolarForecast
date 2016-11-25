package es.agustruiz.solarforecast.model.api.tiempocom;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "location"
})
@XmlRootElement(name = "report")
public class TiempoComR3_ReportAPI {

    @XmlElement(required = true)
    protected TiempoComR3_ReportAPI.Location location;

    public TiempoComR3_ReportAPI.Location getLocation() {
        return location;
    }

    public void setLocation(TiempoComR3_ReportAPI.Location value) {
        this.location = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "interesting",
        "day"
    })
    public static class Location {

        @XmlElement(required = true)
        protected TiempoComR3_ReportAPI.Location.Interesting interesting;
        @XmlElement(required = true)
        protected List<TiempoComR3_ReportAPI.Location.Day> day;
        @XmlAttribute(name = "city")
        protected String city;

        public TiempoComR3_ReportAPI.Location.Interesting getInteresting() {
            return interesting;
        }

        public void setInteresting(TiempoComR3_ReportAPI.Location.Interesting value) {
            this.interesting = value;
        }

        public List<TiempoComR3_ReportAPI.Location.Day> getDay() {
            if (day == null) {
                day = new ArrayList<>();
            }
            return this.day;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String value) {
            this.city = value;
        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "symbol",
            "tempmin",
            "tempmax",
            "wind",
            "windGusts",
            "rain",
            "humidity",
            "pressure",
            "snowline",
            "sun",
            "moon",
            "localInfo",
            "hour"
        })
        public static class Day {

            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Symbol symbol;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Tempmin tempmin;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Tempmax tempmax;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Wind wind;
            @XmlElement(name = "wind-gusts", required = true)
            protected TiempoComR3_ReportAPI.Location.Day.WindGusts windGusts;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Rain rain;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Humidity humidity;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Pressure pressure;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Snowline snowline;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Sun sun;
            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Day.Moon moon;
            @XmlElement(name = "local_info", required = true)
            protected TiempoComR3_ReportAPI.Location.Day.LocalInfo localInfo;
            @XmlElement(required = true)
            protected List<TiempoComR3_ReportAPI.Location.Day.Hour> hour;
            @XmlAttribute(name = "value")
            protected Integer value;
            @XmlAttribute(name = "name")
            protected String name;

            public TiempoComR3_ReportAPI.Location.Day.Symbol getSymbol() {
                return symbol;
            }

            public void setSymbol(TiempoComR3_ReportAPI.Location.Day.Symbol value) {
                this.symbol = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Tempmin getTempmin() {
                return tempmin;
            }

            public void setTempmin(TiempoComR3_ReportAPI.Location.Day.Tempmin value) {
                this.tempmin = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Tempmax getTempmax() {
                return tempmax;
            }

            public void setTempmax(TiempoComR3_ReportAPI.Location.Day.Tempmax value) {
                this.tempmax = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Wind getWind() {
                return wind;
            }

            public void setWind(TiempoComR3_ReportAPI.Location.Day.Wind value) {
                this.wind = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.WindGusts getWindGusts() {
                return windGusts;
            }

            public void setWindGusts(TiempoComR3_ReportAPI.Location.Day.WindGusts value) {
                this.windGusts = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Rain getRain() {
                return rain;
            }

            public void setRain(TiempoComR3_ReportAPI.Location.Day.Rain value) {
                this.rain = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Humidity getHumidity() {
                return humidity;
            }

            public void setHumidity(TiempoComR3_ReportAPI.Location.Day.Humidity value) {
                this.humidity = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Pressure getPressure() {
                return pressure;
            }

            public void setPressure(TiempoComR3_ReportAPI.Location.Day.Pressure value) {
                this.pressure = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Snowline getSnowline() {
                return snowline;
            }

            public void setSnowline(TiempoComR3_ReportAPI.Location.Day.Snowline value) {
                this.snowline = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Sun getSun() {
                return sun;
            }

            public void setSun(TiempoComR3_ReportAPI.Location.Day.Sun value) {
                this.sun = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.Moon getMoon() {
                return moon;
            }

            public void setMoon(TiempoComR3_ReportAPI.Location.Day.Moon value) {
                this.moon = value;
            }

            public TiempoComR3_ReportAPI.Location.Day.LocalInfo getLocalInfo() {
                return localInfo;
            }

            public void setLocalInfo(TiempoComR3_ReportAPI.Location.Day.LocalInfo value) {
                this.localInfo = value;
            }

            public List<TiempoComR3_ReportAPI.Location.Day.Hour> getHour() {
                if (hour == null) {
                    hour = new ArrayList<>();
                }
                return this.hour;
            }

            public Integer getValue() {
                return value;
            }

            public void setValue(Integer value) {
                this.value = value;
            }

            public String getName() {
                return name;
            }

            public void setName(String value) {
                this.name = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "", propOrder = {
                "temp",
                "symbol",
                "wind",
                "windGusts",
                "rain",
                "humidity",
                "pressure",
                "clouds",
                "snowline",
                "windchill"
            })
            public static class Hour {

                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Temp temp;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Symbol symbol;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Wind wind;
                @XmlElement(name = "wind-gusts", required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.WindGusts windGusts;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Rain rain;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Humidity humidity;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Pressure pressure;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Clouds clouds;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Snowline snowline;
                @XmlElement(required = true)
                protected TiempoComR3_ReportAPI.Location.Day.Hour.Windchill windchill;
                @XmlAttribute(name = "value")
                @XmlSchemaType(name = "dateTime")
                protected String value;

                public TiempoComR3_ReportAPI.Location.Day.Hour.Temp getTemp() {
                    return temp;
                }

                public void setTemp(TiempoComR3_ReportAPI.Location.Day.Hour.Temp value) {
                    this.temp = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Symbol getSymbol() {
                    return symbol;
                }

                public void setSymbol(TiempoComR3_ReportAPI.Location.Day.Hour.Symbol value) {
                    this.symbol = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Wind getWind() {
                    return wind;
                }

                public void setWind(TiempoComR3_ReportAPI.Location.Day.Hour.Wind value) {
                    this.wind = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.WindGusts getWindGusts() {
                    return windGusts;
                }

                public void setWindGusts(TiempoComR3_ReportAPI.Location.Day.Hour.WindGusts value) {
                    this.windGusts = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Rain getRain() {
                    return rain;
                }

                public void setRain(TiempoComR3_ReportAPI.Location.Day.Hour.Rain value) {
                    this.rain = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Humidity getHumidity() {
                    return humidity;
                }

                public void setHumidity(TiempoComR3_ReportAPI.Location.Day.Hour.Humidity value) {
                    this.humidity = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Pressure getPressure() {
                    return pressure;
                }

                public void setPressure(TiempoComR3_ReportAPI.Location.Day.Hour.Pressure value) {
                    this.pressure = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Clouds getClouds() {
                    return clouds;
                }

                public void setClouds(TiempoComR3_ReportAPI.Location.Day.Hour.Clouds value) {
                    this.clouds = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Snowline getSnowline() {
                    return snowline;
                }

                public void setSnowline(TiempoComR3_ReportAPI.Location.Day.Hour.Snowline value) {
                    this.snowline = value;
                }

                public TiempoComR3_ReportAPI.Location.Day.Hour.Windchill getWindchill() {
                    return windchill;
                }

                public void setWindchill(TiempoComR3_ReportAPI.Location.Day.Hour.Windchill value) {
                    this.windchill = value;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Clouds {

                    @XmlAttribute(name = "value")
                    protected String value;

                    public String getValue() {
                        return value;
                    }

                    public void setValue(String value) {
                        this.value = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Humidity {

                    @XmlAttribute(name = "value")
                    protected Integer value;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Pressure {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Rain {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Snowline {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Symbol {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "desc")
                    protected String desc;
                    @XmlAttribute(name = "value2")
                    protected Integer value2;
                    @XmlAttribute(name = "desc2")
                    protected String desc2;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getDesc() {
                        return desc;
                    }

                    public void setDesc(String value) {
                        this.desc = value;
                    }

                    public Integer getValue2() {
                        return value2;
                    }

                    public void setValue2(Integer value) {
                        this.value2 = value;
                    }

                    public String getDesc2() {
                        return desc2;
                    }

                    public void setDesc2(String value) {
                        this.desc2 = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Temp {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Wind {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;
                    @XmlAttribute(name = "dir")
                    protected String dir;
                    @XmlAttribute(name = "symbol")
                    protected Integer symbol;
                    @XmlAttribute(name = "symbolB")
                    protected Integer symbolB;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                    public String getDir() {
                        return dir;
                    }

                    public void setDir(String value) {
                        this.dir = value;
                    }

                    public Integer getSymbol() {
                        return symbol;
                    }

                    public void setSymbol(Integer value) {
                        this.symbol = value;
                    }

                    public Integer getSymbolB() {
                        return symbolB;
                    }

                    public void setSymbolB(Integer value) {
                        this.symbolB = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class WindGusts {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

                @XmlAccessorType(XmlAccessType.FIELD)
                @XmlType(name = "")
                public static class Windchill {

                    @XmlAttribute(name = "value")
                    protected Integer value;
                    @XmlAttribute(name = "unit")
                    protected String unit;

                    public Integer getValue() {
                        return value;
                    }

                    public void setValue(Integer value) {
                        this.value = value;
                    }

                    public String getUnit() {
                        return unit;
                    }

                    public void setUnit(String value) {
                        this.unit = value;
                    }

                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Humidity {

                @XmlAttribute(name = "value")
                protected Integer value;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class LocalInfo {

                @XmlAttribute(name = "local_time")
                @XmlSchemaType(name = "dateTime")
                protected String localTime;
                @XmlAttribute(name = "offset")
                protected Integer offset;

                public String getLocalTime() {
                    return localTime;
                }

                public void setLocalTime(String value) {
                    this.localTime = value;
                }

                public Integer getOffset() {
                    return offset;
                }

                public void setOffset(Integer value) {
                    this.offset = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Moon {

                @XmlAttribute(name = "in")
                @XmlSchemaType(name = "dateTime")
                protected String in;
                @XmlAttribute(name = "out")
                @XmlSchemaType(name = "dateTime")
                protected String out;
                @XmlAttribute(name = "lumi")
                protected String lumi;
                @XmlAttribute(name = "desc")
                protected String desc;
                @XmlAttribute(name = "symbol")
                protected Integer symbol;

                public String getIn() {
                    return in;
                }

                public void setIn(String value) {
                    this.in = value;
                }

                public String getOut() {
                    return out;
                }

                public void setOut(String value) {
                    this.out = value;
                }

                public String getLumi() {
                    return lumi;
                }

                public void setLumi(String value) {
                    this.lumi = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String value) {
                    this.desc = value;
                }

                public Integer getSymbol() {
                    return symbol;
                }

                public void setSymbol(Integer value) {
                    this.symbol = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Pressure {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Rain {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Snowline {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Sun {

                @XmlAttribute(name = "in")
                @XmlSchemaType(name = "dateTime")
                protected String in;
                @XmlAttribute(name = "mid")
                @XmlSchemaType(name = "dateTime")
                protected String mid;
                @XmlAttribute(name = "out")
                @XmlSchemaType(name = "dateTime")
                protected String out;

                public String getIn() {
                    return in;
                }

                public void setIn(String value) {
                    this.in = value;
                }

                public String getMid() {
                    return mid;
                }

                public void setMid(String value) {
                    this.mid = value;
                }

                public String getOut() {
                    return out;
                }

                public void setOut(String value) {
                    this.out = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Symbol {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "desc")
                protected String desc;
                @XmlAttribute(name = "value2")
                protected Integer value2;
                @XmlAttribute(name = "desc2")
                protected String desc2;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getDesc() {
                    return desc;
                }

                public void setDesc(String value) {
                    this.desc = value;
                }

                public Integer getValue2() {
                    return value2;
                }

                public void setValue2(Integer value) {
                    this.value2 = value;
                }

                public String getDesc2() {
                    return desc2;
                }

                public void setDesc2(String value) {
                    this.desc2 = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Tempmax {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Tempmin {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Wind {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;
                @XmlAttribute(name = "symbol")
                protected Integer symbol;
                @XmlAttribute(name = "symbolB")
                protected Integer symbolB;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

                public Integer getSymbol() {
                    return symbol;
                }

                public void setSymbol(Integer value) {
                    this.symbol = value;
                }

                public Integer getSymbolB() {
                    return symbolB;
                }

                public void setSymbolB(Integer value) {
                    this.symbolB = value;
                }

            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class WindGusts {

                @XmlAttribute(name = "value")
                protected Integer value;
                @XmlAttribute(name = "unit")
                protected String unit;

                public Integer getValue() {
                    return value;
                }

                public void setValue(Integer value) {
                    this.value = value;
                }

                public String getUnit() {
                    return unit;
                }

                public void setUnit(String value) {
                    this.unit = value;
                }

            }

        }

        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "url"
        })
        public static class Interesting {

            @XmlElement(required = true)
            protected TiempoComR3_ReportAPI.Location.Interesting.Url url;

            public TiempoComR3_ReportAPI.Location.Interesting.Url getUrl() {
                return url;
            }

            public void setUrl(TiempoComR3_ReportAPI.Location.Interesting.Url value) {
                this.url = value;
            }

            @XmlAccessorType(XmlAccessType.FIELD)
            @XmlType(name = "")
            public static class Url {

                @XmlAttribute(name = "description")
                protected String description;

                public String getDescription() {
                    return description;
                }

                public void setDescription(String value) {
                    this.description = value;
                }

            }

        }

    }

}
