package gmail.sjtxm0320.guestbook.service;

import java.util.function.Function;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import gmail.sjtxm0320.guestbook.domain.GuestBook;
import gmail.sjtxm0320.guestbook.dto.GuestBookDTO;
import gmail.sjtxm0320.guestbook.dto.PageRequestDTO;
import gmail.sjtxm0320.guestbook.dto.PageResponseDTO;
import gmail.sjtxm0320.guestbook.persistence.GuestBookRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
@RequiredArgsConstructor
public class GuestServiceImpl implements GuestBookService {
    private final GuestBookRepository guestBookRepository;

    public Long register(GuestBookDTO dto) {
        // 파라미터가 제대로 넘어오는지 확인
        log.info("Insert Data: " + dto.toString());

        // respository의 메서드를 매개변수로 변형
        GuestBook entity = dtoToEntity(dto);
        guestBookRepository.save(entity);

        // save를 할 때, 설정한 내역을 가지고 필요한 데이터를 설정
        // gno, regDate, modDate가 설정된다.
        return entity.getGno();
    }

    // 목록 보기를 위한 메서드
    @Override
    public PageResponseDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO requestDTO) {
        // Repository에게 넘겨줄 Pageable 객체를 생성
        Pageable pageable = requestDTO.getPageable(Sort.by("gno").descending());

        // 데이터 찾아오기
        Page<GuestBook> result = guestBookRepository.findAll(pageable);

        // 데이터 목록을 받아서 데이터 목록을 순회하면서 제공된 메서드가 리턴하는 목록을 변경해주는 람다
        Function<GuestBook, GuestBookDTO> fn = (entity -> entityToDto(entity));

        return new PageResponseDTO<>(result, fn);
    }
}
