
package rs.novotek.domain.model;

import java.io.Serializable;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Poster implements Serializable, Parcelable
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
    private String iso6391;
    @SerializedName("vote_average")
    @Expose
    private Integer voteAverage;
    @SerializedName("vote_count")
    @Expose
    private Integer voteCount;
    @SerializedName("width")
    @Expose
    private Integer width;
    public final static Parcelable.Creator<Poster> CREATOR = new Creator<Poster>() {


        @SuppressWarnings({
            "unchecked"
        })
        public Poster createFromParcel(Parcel in) {
            return new Poster(in);
        }

        public Poster[] newArray(int size) {
            return (new Poster[size]);
        }

    }
    ;
    private final static long serialVersionUID = 5620100151909618363L;

    protected Poster(Parcel in) {
        this.aspectRatio = ((Double) in.readValue((Double.class.getClassLoader())));
        this.filePath = ((String) in.readValue((String.class.getClassLoader())));
        this.height = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.iso6391 = ((String) in.readValue((String.class.getClassLoader())));
        this.voteAverage = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.voteCount = ((Integer) in.readValue((Integer.class.getClassLoader())));
        this.width = ((Integer) in.readValue((Integer.class.getClassLoader())));
    }

    public Poster() {
    }

    public Double getAspectRatio() {
        return aspectRatio;
    }

    public void setAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
    }

    public Poster withAspectRatio(Double aspectRatio) {
        this.aspectRatio = aspectRatio;
        return this;
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public Poster withFilePath(String filePath) {
        this.filePath = filePath;
        return this;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Poster withHeight(Integer height) {
        this.height = height;
        return this;
    }

    public String getIso6391() {
        return iso6391;
    }

    public void setIso6391(String iso6391) {
        this.iso6391 = iso6391;
    }

    public Poster withIso6391(String iso6391) {
        this.iso6391 = iso6391;
        return this;
    }

    public Integer getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Poster withVoteAverage(Integer voteAverage) {
        this.voteAverage = voteAverage;
        return this;
    }

    public Integer getVoteCount() {
        return voteCount;
    }

    public void setVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
    }

    public Poster withVoteCount(Integer voteCount) {
        this.voteCount = voteCount;
        return this;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Poster withWidth(Integer width) {
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
