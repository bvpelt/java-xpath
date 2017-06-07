package nl.bsoft;

import javax.xml.namespace.NamespaceContext;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by bvpelt on 6/6/17.
 * <p>
 * See https://stackoverflow.com/questions/6390339/how-to-query-xml-using-namespaces-in-java-with-xpath
 */
public class MyNamespaceContext implements NamespaceContext {
    private final Map<String, String> PREF_MAP = new HashMap<String, String>();

    public MyNamespaceContext(final Map<String, String> prefMap) {
        PREF_MAP.putAll(prefMap);
    }

    public String getNamespaceURI(String prefix) {
        return PREF_MAP.get(prefix);
    }

    public String getPrefix(String uri) {
        throw new UnsupportedOperationException();
    }

    public Iterator getPrefixes(String uri) {
        throw new UnsupportedOperationException();
    }
}
