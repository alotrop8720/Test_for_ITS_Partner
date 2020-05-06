package base_classes;


import com.maxmind.geoip2.DatabaseReader;
import com.maxmind.geoip2.exception.GeoIp2Exception;
import com.maxmind.geoip2.model.CountryResponse;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.awt.im.InputContext;
import java.io.*;
import java.net.InetAddress;
import java.util.List;
import java.util.logging.Logger;

/**
 * There are implementation еру GEOIP2 library.
 * Only country.
 */
public class GeoIP {
    private static Logger logger = Logger.getLogger(ManagerRooms.class.getName());
    private String ip;
    private DatabaseReader dbReader;
    private CountryResponse response;

    public GeoIP(String ip) {
        this.ip = ip;
        File dbfile = new File("GeoLite2-Country.mmdb");
        String s = dbfile.getAbsolutePath();
        try {
            dbReader = new DatabaseReader.Builder(dbfile).build();
            InetAddress ipAddress = InetAddress.getByName(ip);
            response = dbReader.country(ipAddress);

        }catch (IOException e){
            logger.info(e.getMessage());
        }catch (GeoIp2Exception e) {
            logger.info(e.getMessage());
        }
    }

    /**
     * Get country for ip.
     * @return name of country
     */
    public String getCountry(){
        return response.getCountry().getName();
    }

}
