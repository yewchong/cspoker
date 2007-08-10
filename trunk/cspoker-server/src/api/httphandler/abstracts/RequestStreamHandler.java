/**
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *  
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place - Suite 330, Boston, MA 02111-1307, USA.
 */
package api.httphandler.abstracts;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

import javax.xml.transform.sax.SAXTransformerFactory;
import javax.xml.transform.sax.TransformerHandler;
import javax.xml.transform.stream.StreamResult;

import org.xml.sax.ContentHandler;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.sun.net.httpserver.HttpExchange;

public abstract class RequestStreamHandler extends HttpHandlerImpl {

    public void handle(HttpExchange http) throws IOException {
	ByteArrayOutputStream responseBody = new ByteArrayOutputStream();
	TransformerHandler response=null;
	StreamResult requestResult;
	try {
	    requestResult = new StreamResult(responseBody);
	    SAXTransformerFactory tf = (SAXTransformerFactory) SAXTransformerFactory
	    .newInstance();
	    response = tf.newTransformerHandler();
	    response.setResult(requestResult);
	    response.startDocument();
	    try {
		XMLReader xr = XMLReaderFactory.createXMLReader();
		xr.setContentHandler(getRequestHandler(http, response));
		xr.parse(new InputSource(http.getRequestBody()));
	    } catch (SAXException e) {
		throw new IOException(e);
	    }
	    response.endDocument();
	} catch (Exception e) {
	    throwException(http, e);
	    return;
	}
	
	http.sendResponseHeaders(getDefaultStatusCode(), responseBody.size());
	responseBody.writeTo(http.getResponseBody());
	http.getResponseBody().close();
	http.close();

    }
    
    protected abstract ContentHandler getRequestHandler(HttpExchange http, TransformerHandler response);

}
