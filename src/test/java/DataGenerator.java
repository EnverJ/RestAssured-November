import com.github.javafaker.Faker;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.w3c.dom.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.util.Date;
import java.util.TimeZone;
import java.util.concurrent.TimeUnit;


@Slf4j
public class DataGenerator {
    public static final String bookStore = "Amazon";
    @Getter
    private final Faker faker = new Faker();

    @Getter
    public SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public String createDevisionId(String id) {
     return id + "." + faker.number().digits(4);
    }

    public String createBillingAccountNumber() {
        return faker.number().digits(10);
    }

    public String createFqAccountId(String id) {
        String fqAccountId = id + "/" + createBillingAccountNumber();
        log.info("\nCreating document with fqAccountId : "+fqAccountId);
        return fqAccountId;
    }
    public String getPastDate(String datPattern){
        return convertDateFormat(faker.date().past(Integer.parseInt(faker.number().digits(3)), TimeUnit.DAYS),
        datPattern);
    }

    public String convertDateFormat(Date rawDate, String pattern) {
        SimpleDateFormat dateFormat;
        if(pattern == null){
            dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        }   else {
            dateFormat = new SimpleDateFormat();
        }
        TimeZone timeZone = TimeZone.getTimeZone("America/California");
        dateFormat.setTimeZone(timeZone);
        return dateFormat.format(rawDate);
    }

    public void CreateActivityLog(String traceId, Document activityContextData, Instant now) {
        Document document = new Document() {
            @Override
            public String getNodeName() {
                return null;
            }

            @Override
            public String getNodeValue() throws DOMException {
                return null;
            }

            @Override
            public void setNodeValue(String nodeValue) throws DOMException {

            }

            @Override
            public short getNodeType() {
                return 0;
            }

            @Override
            public Node getParentNode() {
                return null;
            }

            @Override
            public NodeList getChildNodes() {
                return null;
            }

            @Override
            public Node getFirstChild() {
                return null;
            }

            @Override
            public Node getLastChild() {
                return null;
            }

            @Override
            public Node getPreviousSibling() {
                return null;
            }

            @Override
            public Node getNextSibling() {
                return null;
            }

            @Override
            public NamedNodeMap getAttributes() {
                return null;
            }

            @Override
            public Document getOwnerDocument() {
                return null;
            }

            @Override
            public Node insertBefore(Node newChild, Node refChild) throws DOMException {
                return null;
            }

            @Override
            public Node replaceChild(Node newChild, Node oldChild) throws DOMException {
                return null;
            }

            @Override
            public Node removeChild(Node oldChild) throws DOMException {
                return null;
            }

            @Override
            public Node appendChild(Node newChild) throws DOMException {
                return null;
            }

            @Override
            public boolean hasChildNodes() {
                return false;
            }

            @Override
            public Node cloneNode(boolean deep) {
                return null;
            }

            @Override
            public void normalize() {

            }

            @Override
            public boolean isSupported(String feature, String version) {
                return false;
            }

            @Override
            public String getNamespaceURI() {
                return null;
            }

            @Override
            public String getPrefix() {
                return null;
            }

            @Override
            public void setPrefix(String prefix) throws DOMException {

            }

            @Override
            public String getLocalName() {
                return null;
            }

            @Override
            public boolean hasAttributes() {
                return false;
            }

            @Override
            public String getBaseURI() {
                return null;
            }

            @Override
            public short compareDocumentPosition(Node other) throws DOMException {
                return 0;
            }

            @Override
            public String getTextContent() throws DOMException {
                return null;
            }

            @Override
            public void setTextContent(String textContent) throws DOMException {

            }

            @Override
            public boolean isSameNode(Node other) {
                return false;
            }

            @Override
            public String lookupPrefix(String namespaceURI) {
                return null;
            }

            @Override
            public boolean isDefaultNamespace(String namespaceURI) {
                return false;
            }

            @Override
            public String lookupNamespaceURI(String prefix) {
                return null;
            }

            @Override
            public boolean isEqualNode(Node arg) {
                return false;
            }

            @Override
            public Object getFeature(String feature, String version) {
                return null;
            }

            @Override
            public Object setUserData(String key, Object data, UserDataHandler handler) {
                return null;
            }

            @Override
            public Object getUserData(String key) {
                return null;
            }

            @Override
            public DocumentType getDoctype() {
                return null;
            }

            @Override
            public DOMImplementation getImplementation() {
                return null;
            }

            @Override
            public Element getDocumentElement() {
                return null;
            }

            @Override
            public Element createElement(String tagName) throws DOMException {
                return null;
            }

            @Override
            public DocumentFragment createDocumentFragment() {
                return null;
            }

            @Override
            public Text createTextNode(String data) {
                return null;
            }

            @Override
            public Comment createComment(String data) {
                return null;
            }

            @Override
            public CDATASection createCDATASection(String data) throws DOMException {
                return null;
            }

            @Override
            public ProcessingInstruction createProcessingInstruction(String target, String data) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttribute(String name) throws DOMException {
                return null;
            }

            @Override
            public EntityReference createEntityReference(String name) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagName(String tagname) {
                return null;
            }

            @Override
            public Node importNode(Node importedNode, boolean deep) throws DOMException {
                return null;
            }

            @Override
            public Element createElementNS(String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }

            @Override
            public Attr createAttributeNS(String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }

            @Override
            public NodeList getElementsByTagNameNS(String namespaceURI, String localName) {
                return null;
            }

            @Override
            public Element getElementById(String elementId) {
                return null;
            }

            @Override
            public String getInputEncoding() {
                return null;
            }

            @Override
            public String getXmlEncoding() {
                return null;
            }

            @Override
            public boolean getXmlStandalone() {
                return false;
            }

            @Override
            public void setXmlStandalone(boolean xmlStandalone) throws DOMException {

            }

            @Override
            public String getXmlVersion() {
                return null;
            }

            @Override
            public void setXmlVersion(String xmlVersion) throws DOMException {

            }

            @Override
            public boolean getStrictErrorChecking() {
                return false;
            }

            @Override
            public void setStrictErrorChecking(boolean strictErrorChecking) {

            }

            @Override
            public String getDocumentURI() {
                return null;
            }

            @Override
            public void setDocumentURI(String documentURI) {

            }

            @Override
            public Node adoptNode(Node source) throws DOMException {
                return null;
            }

            @Override
            public DOMConfiguration getDomConfig() {
                return null;
            }

            @Override
            public void normalizeDocument() {

            }

            @Override
            public Node renameNode(Node n, String namespaceURI, String qualifiedName) throws DOMException {
                return null;
            }
        };



    }
}
