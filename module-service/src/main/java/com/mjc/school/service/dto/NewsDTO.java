package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsDTO {
    private long id;
    private String title;
    private String content;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdateDate;
    private long authorID;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsDTO newsDTO)) return false;
        return id == newsDTO.id
                && authorID == newsDTO.authorID
                && Objects.equals(title, newsDTO.title)
                && Objects.equals(content, newsDTO.content)
                && Objects.equals(createDate, newsDTO.createDate)
                && Objects.equals(lastUpdateDate, newsDTO.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorID);
    }

    @Override
    public String toString() {
        return "NewsDTO{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createDate=" + createDate +
                ", lastUpdateDate=" + lastUpdateDate +
                ", authorID=" + authorID +
                '}';
    }
}
