package com.mjc.school.service.dto;

import java.time.LocalDateTime;
import java.util.Objects;

public class NewsDTO {
    private final long id;
    private final String title;
    private final String content;
    private final LocalDateTime createDate;
    private final LocalDateTime lastUpdateDate;
    private final long authorID;
    public NewsDTO(long id, String title, String content, LocalDateTime createDate, LocalDateTime lastUpdateDate, long authorID) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.createDate = createDate;
        this.lastUpdateDate = lastUpdateDate;
        this.authorID = authorID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NewsDTO newsDTO)) return false;
        return id == newsDTO.id && authorID == newsDTO.authorID && Objects.equals(title, newsDTO.title) && Objects.equals(content, newsDTO.content) && Objects.equals(createDate, newsDTO.createDate) && Objects.equals(lastUpdateDate, newsDTO.lastUpdateDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, createDate, lastUpdateDate, authorID);
    }

    @Override
    public String toString() {
        return "NewsDTO{" + "id=" + id + ", title='" + title + '\'' + ", content='" + content + '\'' + ", createDate=" + createDate + ", lastUpdateDate=" + lastUpdateDate + ", authorID=" + authorID + '}';
    }
}
