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
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "location"
})
@XmlRootElement(name = "report")
public class TiempoComR3_ReportAPI {

    @XmlElement(required = true)
    protected Report.Location location;

    public Report.Location getLocation() {
        return location;
    }

    public void setLocation(Report.Location value) {
        this.location = value;
    }

    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "interesting",
        "day"
    })
    public static class Location {

        @XmlElement(required = true)
        protected Report.Location.Interesting interesting;
        @XmlElement(required = true)
        protected List<Report.Location.Day> day;
        @XmlAttribute(name = "city")
        protected String city;

        public Report.Location.Interesting getInteresting() {
            return interesting;
        }

        public void setInteresting(Report.Location.Interesting value) {
            this.interesting = value;
        }

        public List<Report.Location.Day> getDay() {
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
            protected Report.Location.Day.Symbol symbol;
            @XmlElement(required = true)
            protected Report.Location.Day.Tempmin tempmin;
            @XmlElement(required = true)
            protected Report.Location.Day.Tempmax tempmax;
            @XmlElement(required = true)
            protected Report.Location.Day.Wind wind;
            @XmlElement(name = "wind-gusts", required = true)
            protected Report.Location.Day.WindGusts windGusts;
            @XmlElement(required = true)
            protected Report.Location.Day.Rain rain;
            @XmlElement(required = true)
            protected Report.Location.Day.Humidity humidity;
            @XmlElement(required = true)
            protected Report.Location.Day.Pressure pressure;
            @XmlElement(required = true)
            protected Report.Location.Day.Snowline snowline;
            @XmlElement(required = true)
            protected Report.Location.Day.Sun sun;
            @XmlElement(required = true)
            protected Report.Location.Day.Moon moon;
            @XmlElement(name = "local_info", required = true)
            protected Report.Location.Day.LocalInfo localInfo;
            @XmlElement(required = true)
            protected List<Report.Location.Day.Hour> hour;
            @XmlAttribute(name = "value")
            protected Integer value;
            @XmlAttribute(name = "name")
            protected String name;

            public Report.Location.Day.Symbol getSymbol() {
                return symbol;
            }

            public void setSymbol(Report.Location.Day.Symbol value) {
                this.symbol = value;
            }

            public Report.Location.Day.Tempmin getTempmin() {
                return tempmin;
            }

            public void setTempmin(Report.Location.Day.Tempmin value) {
                this.tempmin = value;
            }

            public Report.Location.Day.Tempmax getTempmax() {
                return tempmax;
            }

            public void setTempmax(Report.Location.Day.Tempmax value) {
                this.tempmax = value;
            }

            public Report.Location.Day.Wind getWind() {
                return wind;
            }

            public void setWind(Report.Location.Day.Wind value) {
                this.wind = value;
            }

            public Report.Location.Day.WindGusts getWindGusts() {
                return windGusts;
            }

            public void setWindGusts(Report.Location.Day.WindGusts value) {
                this.windGusts = value;
            }

            public Report.Location.Day.Rain getRain() {
                return rain;
            }

            public void setRain(Report.Location.Day.Rain value) {
                this.rain = value;
            }

            public Report.Location.Day.Humidity getHumidity() {
                return humidity;
            }

            public void setHumidity(Report.Location.Day.Humidity value) {
                this.humidity = value;
            }

            public Report.Location.Day.Pressure getPressure() {
                return pressure;
            }

            public void setPressure(Report.Location.Day.Pressure value) {
                this.pressure = value;
            }

            public Report.Location.Day.Snowline getSnowline() {
                return snowline;
            }

            public void setSnowline(Report.Location.Day.Snowline value) {
                this.snowline = value;
            }

            public Report.Location.Day.Sun getSun() {
                return sun;
            }

            public void setSun(Report.Location.Day.Sun value) {
                this.sun = value;
            }

            public Report.Location.Day.Moon getMoon() {
                return moon;
            }

            public void setMoon(Report.Location.Day.Moon value) {
                this.moon = value;
            }

            public Report.Location.Day.LocalInfo getLocalInfo() {
                return localInfo;
            }

            public void setLocalInfo(Report.Location.Day.LocalInfo value) {
                this.localInfo = value;
            }

            public List<Report.Location.Day.Hour> getHour() {
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
                protected Report.Location.Day.Hour.Temp temp;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Symbol symbol;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Wind wind;
                @XmlElement(name = "wind-gusts", required = true)
                protected Report.Location.Day.Hour.WindGusts windGusts;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Rain rain;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Humidity humidity;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Pressure pressure;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Clouds clouds;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Snowline snowline;
                @XmlElement(required = true)
                protected Report.Location.Day.Hour.Windchill windchill;
                @XmlAttribute(name = "value")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar value;

                public Report.Location.Day.Hour.Temp getTemp() {
                    return temp;
                }

                public void setTemp(Report.Location.Day.Hour.Temp value) {
                    this.temp = value;
                }

                public Report.Location.Day.Hour.Symbol getSymbol() {
                    return symbol;
                }

                public void setSymbol(Report.Location.Day.Hour.Symbol value) {
                    this.symbol = value;
                }

                public Report.Location.Day.Hour.Wind getWind() {
                    return wind;
                }

                public void setWind(Report.Location.Day.Hour.Wind value) {
                    this.wind = value;
                }

                public Report.Location.Day.Hour.WindGusts getWindGusts() {
                    return windGusts;
                }

                public void setWindGusts(Report.Location.Day.Hour.WindGusts value) {
                    this.windGusts = value;
                }

                public Report.Location.Day.Hour.Rain getRain() {
                    return rain;
                }

                public void setRain(Report.Location.Day.Hour.Rain value) {
                    this.rain = value;
                }

                public Report.Location.Day.Hour.Humidity getHumidity() {
                    return humidity;
                }

                public void setHumidity(Report.Location.Day.Hour.Humidity value) {
                    this.humidity = value;
                }

                public Report.Location.Day.Hour.Pressure getPressure() {
                    return pressure;
                }

                public void setPressure(Report.Location.Day.Hour.Pressure value) {
                    this.pressure = value;
                }

                public Report.Location.Day.Hour.Clouds getClouds() {
                    return clouds;
                }

                public void setClouds(Report.Location.Day.Hour.Clouds value) {
                    this.clouds = value;
                }

                public Report.Location.Day.Hour.Snowline getSnowline() {
                    return snowline;
                }

                public void setSnowline(Report.Location.Day.Hour.Snowline value) {
                    this.snowline = value;
                }

                public Report.Location.Day.Hour.Windchill getWindchill() {
                    return windchill;
                }

                public void setWindchill(Report.Location.Day.Hour.Windchill value) {
                    this.windchill = value;
                }

                public XMLGregorianCalendar getValue() {
                    return value;
                }

                public void setValue(XMLGregorianCalendar value) {
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
                protected XMLGregorianCalendar localTime;
                @XmlAttribute(name = "offset")
                protected Integer offset;

                public XMLGregorianCalendar getLocalTime() {
                    return localTime;
                }

                public void setLocalTime(XMLGregorianCalendar value) {
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
                protected XMLGregorianCalendar in;
                @XmlAttribute(name = "out")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar out;
                @XmlAttribute(name = "lumi")
                protected String lumi;
                @XmlAttribute(name = "desc")
                protected String desc;
                @XmlAttribute(name = "symbol")
                protected Integer symbol;

                public XMLGregorianCalendar getIn() {
                    return in;
                }

                public void setIn(XMLGregorianCalendar value) {
                    this.in = value;
                }

                public XMLGregorianCalendar getOut() {
                    return out;
                }

                public void setOut(XMLGregorianCalendar value) {
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
                protected XMLGregorianCalendar in;
                @XmlAttribute(name = "mid")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar mid;
                @XmlAttribute(name = "out")
                @XmlSchemaType(name = "dateTime")
                protected XMLGregorianCalendar out;

                public XMLGregorianCalendar getIn() {
                    return in;
                }

                public void setIn(XMLGregorianCalendar value) {
                    this.in = value;
                }

                public XMLGregorianCalendar getMid() {
                    return mid;
                }

                public void setMid(XMLGregorianCalendar value) {
                    this.mid = value;
                }

                public XMLGregorianCalendar getOut() {
                    return out;
                }

                public void setOut(XMLGregorianCalendar value) {
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
            protected Report.Location.Interesting.Url url;

            public Report.Location.Interesting.Url getUrl() {
                return url;
            }

            public void setUrl(Report.Location.Interesting.Url value) {
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
