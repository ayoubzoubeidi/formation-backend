package com.isi.formation.services;

import com.isi.formation.repository.FormationRepository;
import com.isi.formation.repository.ParticipantRepository;
import com.isi.formation.repository.SessionRepository;
import com.isi.formation.web.models.DashboardStatistics;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StatisticsServiceImpl implements StatisticsService {

    private final FormationRepository formationRepository;
    private final SessionRepository sessionRepository;
    private final ParticipantRepository participantRepository;

    @Override
    @Cacheable("statistics")
    public DashboardStatistics getDashboardStatistics() {
        var statistics = new DashboardStatistics();

        statistics.setTotalFormation(formationRepository.count());
        statistics.setTotalSessions(sessionRepository.count());
        statistics.setTotalParticipants(participantRepository.count());

        return statistics;
    }
}
