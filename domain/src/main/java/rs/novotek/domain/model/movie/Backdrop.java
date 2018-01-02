
package rs.novotek.domain.model.movie;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Backdrop implements Serializable, Parcelable
{

    @SerializedName("aspect_ratio")
    @Expose
    private Double aspectRatio;
    @SerializedName("file_path")
    @Expose
    private String filePath;
    @SerializedName("height")
    @Expose
    private Integer height;
    @SerializedName("iso_639_1")
    @Expose
    private Object iso6391;
    @SerializedName("vote_average")
    @Expose
    private Integer voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("width")
    @Expose
    private Integer width;
    public final static Parcelable.Creator<Backdrop> CREATOR = new Creator<Backdrop>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Backdrop createFromParcel(Parcel in) {
            return new Backdrop(in);
        }

        public Backdrop[] newArray(int size) {
            return (new Backdrop[size]);
        }

    }
    ;
    private final static long serialVersionUID = 1063414818691850382L;

    protected Backdrop(Parcel in) {
        this.aspectRatio = ((Double) in.readValue((Double.class.getClassLoader())));
        this.filePath = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.iso6391 = ((Object) in.readValue((Object.class.getClassLoader())));
        this.voteAverage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.voteCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Backdrop() {
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Backdrop withAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Backdrop withFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Backdrop withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public Object getIso6391() {
        return iso6391;
    }

    public void setIso6391(Object iso6391) {
        this.iso6391 = iso6391;
    }

    public Backdrop withIso6391(Object iso6391) {
        this.iso6391 = iso6391;
        return this;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Backdrop withVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Backdrop withVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Backdrop withWidth(Integer width) {
        this.width = width;
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("aspectRatio", aspectRatio).append("filePath", filePath).append("height", height).append("iso6391", iso6391).append("voteAverage", voteAverage).append("voteCount", voteCount).append("width", width).toString();
    }

    public void writeToParcel(Parcel dest, int flags) {
        dest.writeValue(aspectRatio);
        dest.writeValue(filePath);
        dest.writeValue(height);
        dest.writeValue(iso6391);
        dest.writeValue(voteAverage);
        dest.writeValue(voteCount);
        dest.writeValue(width);
    }

    public int describeContents() {
        return  0;
    }

}
