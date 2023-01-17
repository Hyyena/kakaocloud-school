package gmail.sjtxm0320.moviereviewproject.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import gmail.sjtxm0320.moviereviewproject.domain.Movie;
import gmail.sjtxm0320.moviereviewproject.domain.MovieImage;
import gmail.sjtxm0320.moviereviewproject.dto.MovieDTO;
import gmail.sjtxm0320.moviereviewproject.dto.MovieImageDTO;

public interface MovieService {
    // 데이터 삽입을 위한 메서드
    Long register(MovieDTO movieDTO);

    /*
     * DTO를 Entity로 변환
     * 하나의 Entity가 아니라 Movie와 MovieImage로 변환이 돼야하기 때문에 Map으로 리턴
     */
    default Map<String, Object> dtoToEntity(MovieDTO movieDTO) {
        Map<String, Object> entityMap = new HashMap<>();

        Movie movie = Movie.builder().mno(movieDTO.getMno()).title(movieDTO.getTitle()).build();
        entityMap.put("movie", movie);

        // MovieImageDTO의 List
        List<MovieImageDTO> imageDTOList = movieDTO.getImageDTOList();

        // MovieImageDTO의 List를 MovieImage Entity의 List로 변환
        if (imageDTOList == null && imageDTOList.size() > 0) {
            List<MovieImage> movieImageList = imageDTOList.stream().map(movieImageDTO -> {
                MovieImage movieImag = MovieImage.builder()
                    .path(movieImageDTO.getPath())
                    .imgName(movieImageDTO.getImgName())
                    .uuid(movieImageDTO.getUuid())
                    .movie(movie)
                    .build();

                return movieImag;
            }).collect(Collectors.toList());
            entityMap.put("imgList", movieImageList);
        }

        return entityMap;
    }
}
