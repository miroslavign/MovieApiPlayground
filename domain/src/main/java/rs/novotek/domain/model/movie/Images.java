
package rs.novotek.domain.model.movie;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Images implements Serializable, Parcelable
{

    @SerializedName("backdrops")
    @Expose
    private List<Backdrop> backdrops = new ArrayList<Backdrop>();
    @SerializedName("posters")
    @Expose
    private List<Poster> posters = new ArrayList<Poster>();
    public final static Parcelable.Creator<Images> CREATOR = new Creator<Images>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Images createFromParcel(Parcel in) {
            return new Images(in);
        }

        public Images[] newArray(int size) {
            return (new Images[size]);
        }

    }
    ;
    private final static long serialVersionUID = 3019197028034900028L;

    protected Images(Parcel in) {
        in.readList(this.backdrops, (Backdrop.class.getClassLoader()));
        in.readList(this.posters, (Poster.class.getClassLoader()));
    }

    public Images() {
    }

    public List<Backdrop> getBackdrops() {
        return backdrops;
    }

    public void setBackdrops(List<Backdrop> backdrops) {
        this.backdrops = backdrops;
    }

    public Images withBackdrops(List<Backdrop> backdrops) {
        this.backdrops = backdrops;
        return this;
    }

    public List<Poster> getPosters() {
        return posters;
    }

    public void setPosters(List<Poster> posters) {
        this.posters = posters;
    }

    public Images withPosters(List<Poster> posters) {
        this.posters = posters;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("backdrops", backdrops).append("posters", posters).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeList(backdrops);
        dest.writeList(posters);
    }

    public int describeContents() {
        return  0;
    }

}
