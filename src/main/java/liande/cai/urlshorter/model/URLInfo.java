package liande.cai.urlshorter.model;

/**
 * Description:
 * 
 * @author liandecai
 * @time Jun 21, 2014
 */
public class URLInfo {

    public int id;
    public String longUrl;

    public URLInfo() {
    }

    public URLInfo(String longUrl) {
        this.longUrl = longUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLongUrl() {
        return longUrl;
    }

    public void setLongUrl(String longUrl) {
        this.longUrl = longUrl;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((longUrl == null) ? 0 : longUrl.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        URLInfo other = (URLInfo) obj;
        if (id != other.id)
            return false;
        if (longUrl == null) {
            if (other.longUrl != null)
                return false;
        } else if (!longUrl.equals(other.longUrl))
            return false;
        return true;
    }

    
}
