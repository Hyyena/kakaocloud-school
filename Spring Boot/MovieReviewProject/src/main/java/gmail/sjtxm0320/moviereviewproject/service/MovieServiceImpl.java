package gmail.sjtxm0320.moviereviewproject.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.MovieImage;
import gmail.sjtxm0320.moviereviewproject.dto.MovieDTO;
import gmail.sjtxm0320.moviereviewproject.dto.PageRequestDTO;
import gmail.sjtxm0320.moviereviewproject.dto.PageResponseDTO;
import gmail.sjtxm0320.moviereviewproject.persistence.MovieImageRepository;
import gmail.sjtxm0320.moviereviewproject.persistence.MovieRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class MovieServiceImpl implements MovieService {
    private final MovieRepository movieRepository;
    private final MovieImageRepository movieImageRepository;

    @Override
    @Transactional
    public Long register(MovieDTO movieDTO) {
        log.warn("movieDTO: " + movieDTO);

        Map<String, Object> entityMap = dtoToEntity(movieDTO);
        System.out.println(entityMap);

        // 영화와 영화 이미지 정보 찾아오기
        Movie movie = (Movie)entityMap.get("movie");
        List<MovieImage> movieImageList = (List<MovieImage>)entityMap.get("imgList");
        System.out.println(movie);
        System.out.println(movieImageList);

        movieRepository.save(movie);
        movieImageList.forEach(movieImage -> {
            movieImageRepository.save(movieImage);
        });

        return movie.getMno();
    }

    @Override
    public PageResponseDTO<MovieDTO, Object[]> getList(PageRequestDTO requestDTO) {
        // 정렬 조건을 추가해서 Pageable 객체 생성
        Pageable pageable = requestDTO.getPageable(Sort.by("mno").descending());

        // 데이터베이스에 요청
        Page<Object[]> result = movieRepository.getList(pageable);

        /*
         * Object 배열을 MovieDTO 타입으로 변경하기 위해 함수 생성
         * 첫 번째 데이터: Movie
         * 두 번째 데이터: List<MovieImage>
         * 세 번째 데이터: 평점 평균
         * 네 번째 데이터: 리뷰 개수
         */
        Function<Object[], MovieDTO> fn = (arr -> entitiesToDTO((Movie)arr[0],
            (List<MovieImage>)(Arrays.asList((MovieImage)arr[1])), (Double)arr[2], (Long)arr[3]));

        return new PageResponseDTO<>(result, fn);
    }
}
