package cacttus.education.taxiqera.mappers;

public interface MapEntityToDto<E, D> {

    public E toEntity(D item);

    public D toDto(E item);

}
