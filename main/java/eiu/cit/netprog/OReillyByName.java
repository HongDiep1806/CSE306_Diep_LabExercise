package eiu.cit.netprog;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Hello world!
 *
 */
public class OReillyByName {

    public static void main(String[] args) {

        try {

            InetAddress address = InetAddress.getByName("www.eiu.edu.vn");

            System.out.println(address);

        } catch (UnknownHostException ex) {

            System.out.println("Could not find www.oreilly.com");

        }

    }

}
