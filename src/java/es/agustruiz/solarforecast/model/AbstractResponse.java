package es.agustruiz.solarforecast.model;

/**
 *
 * @author Agustin Ruiz Linares <arl00029@red.ujaen.es>
 */
public class AbstractResponse {
    
    protected long queryTimestamp;
    public static final String PARAM_QUERY_TIMESTAMP_TAG = "queryRequestTimestamp";

    public long getQueryTimestamp() {
        return queryTimestamp;
    }

    public void setQueryTimestamp(long queryTimestamp) {
        this.queryTimestamp = queryTimestamp;
    }
    
}
