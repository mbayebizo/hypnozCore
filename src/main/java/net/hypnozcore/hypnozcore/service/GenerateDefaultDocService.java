package net.hypnozcore.hypnozcore.service;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import lombok.extern.slf4j.Slf4j;
import net.hypnozcore.hypnozcore.utils.FileUtils;
import net.hypnozcore.hypnozcore.utils.HypnozCoreCostance;
import net.hypnozcore.hypnozcore.utils.OsUtils;
import net.hypnozcore.hypnozcore.utils.exceptions.ResponseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@FieldDefaults(level = AccessLevel.PRIVATE)
@Transactional
@NoArgsConstructor
public class GenerateDefaultDocService {
    static final Logger LOGGER = LoggerFactory.getLogger(GenerateDefaultDocService.class);

    public String create() throws ResponseException {
        String path = OsUtils.getOsHomeDir();
        if (!FileUtils.existed(path)) {
            FileUtils.mkdir(path);
        }
        if (FileUtils.existed(path)) {
            if (!FileUtils.existed(path + "/" + HypnozCoreCostance.DIR_TEMP)) {
                FileUtils.mkdir(path + "/" + HypnozCoreCostance.DIR_TEMP);
            }
            if (!FileUtils.existed(path + "/" + HypnozCoreCostance.DIR_LOG)) {
                FileUtils.mkdir(path + "/" + HypnozCoreCostance.DIR_LOG);
            }

        }
        return path;
    }

}
