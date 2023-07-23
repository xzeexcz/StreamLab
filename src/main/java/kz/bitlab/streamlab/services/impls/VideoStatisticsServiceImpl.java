package kz.bitlab.streamlab.services.impls;

import kz.bitlab.streamlab.api.serialization.VideoStatisticsSerialization;
import kz.bitlab.streamlab.services.VideoStatisticsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VideoStatisticsServiceImpl implements VideoStatisticsService {
    private final VideoStatisticsSerialization videoStatisticsSerialization;
}
