package company.app.utils.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PagingInfo {
    private Integer count;
    private Integer totalPage;
    private Integer page;
    private Integer size;
}

