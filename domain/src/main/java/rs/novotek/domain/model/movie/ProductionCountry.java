
package rs.novotek.domain.model.movie;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductionCountry implements Serializable, Parcelable
{

    @SerializedName("iso_3166_1")
    @Expose
    private String iso31661;
    @SerializedName("name")
    @Expose
    private String name;
    public final static Parcelable.Creator<ProductionCountry> CREATOR = new Creator<ProductionCountry>() {


        @SuppressWarnings({
            "unchecked"
        })
        public ProductionCountry createFromParcel(Parcel in) {
            return new ProductionCountry(in);
        }

        public ProductionCountry[] newArray(int size) {
            return (new ProductionCountry[size]);
        }

    }
    ;
    private final static long serialVersionUID = 2383821750601530667L;

    protected ProductionCountry(Parcel in) {
        this.iso31661 = ((String) in.readValue((String.class.getClassLoader())));
        this.name = ((String) in.readValue((String.class.getClassLoader())));
    }

    public ProductionCountry() {
    }

    public String getIso31661() {
        return iso31661;
    }

    public void setIso31661(String iso31661) {
        this.iso31661 = iso31661;
    }

    public ProductionCountry withIso31661(String iso31661) {
        this.iso31661 = iso31661;
        return this;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductionCountry withName(String name) {
        this.name = name;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("iso31661", iso31661).append("name", name).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(iso31661);
        dest.writeValue(name);
    }

    public int describeContents() {
        return  0;
    }

}
