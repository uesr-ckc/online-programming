package com.onlineProgramming.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author CKC
 * @DateTime 2021/4/28 18:31
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class PackageEntity {
    private User user;
    private String filename;
    private String contents;
    private String suffix;
}
