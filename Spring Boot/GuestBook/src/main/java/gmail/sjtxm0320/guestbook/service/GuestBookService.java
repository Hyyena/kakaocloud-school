package gmail.sjtxm0320.guestbook.service;

import gmail.sjtxm0320.guestbook.domain.GuestBook;
import gmail.sjtxm0320.guestbook.dto.GuestBookDTO;
import gmail.sjtxm0320.guestbook.dto.PageRequestDTO;
import gmail.sjtxm0320.guestbook.dto.PageResponseDTO;

public interface GuestBookService {
    // 데이터 삽입을 위한 메서드
    // 매개변수는 대부분의 경우 DTO
    // 리턴 타입은 삽입된 데이터를 그대로 리턴하기도 하고,
    // 성공과 실패 여부를 위해 boolean을 리턴하기도 하고,
    // 영향 받은 행의 개수를 의미하는 int
    // 기본키의 값을 리턴하는 경우도 있다.
    public Long register(GuestBookDTO dto);

    // 데이터 목록을 가져오는 메서드
    PageResponseDTO<GuestBookDTO, GuestBook> getList(PageRequestDTO requestDTO);

    // DTO를 Entity로 변환해주는 메서드
    default GuestBook dtoToEntity(GuestBookDTO dto) {
        // 삽입 날짜와 수정 날짜는 entity가 삽입되거나 수정될 때 생성되므로 옮겨줄 필요가 없다.
        GuestBook entity = GuestBook.builder().gno(dto.getGno()).title(dto.getTitle()).content(dto.getContent()).writer(
            dto.getWriter()).build();

        return entity;
    }

    // entity를 dto로 변환해주는 메서드(전부 옮겨주어야 한다.)
    default GuestBookDTO entityToDto(GuestBook entity) {
        GuestBookDTO dto = GuestBookDTO.builder()
            .gno(entity.getGno())
            .title(entity.getTitle())
            .content(
                entity.getTitle())
            .writer(entity.getWriter())
            .regDate(entity.getRegDate())
            .modDate(entity.getModDate())
            .build();

        return dto;
    }
}
