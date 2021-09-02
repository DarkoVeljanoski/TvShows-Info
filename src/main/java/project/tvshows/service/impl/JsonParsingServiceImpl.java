package project.tvshows.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import project.tvshows.model.Show;
import project.tvshows.service.JsonParsingService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class JsonParsingServiceImpl implements JsonParsingService {

    @Autowired
    private RestTemplate restTemplate;

    private Object object;

    @Override
    public Object parse(String url) {

        object = restTemplate.getForObject(url, Object.class);
        return object;
    }

   /* @Override
    public Object post(String url) {
        Show[] shows = restTemplate.postForObject( url, ,Object[].class );
        return shows;
    }*/

    /*@Override
    public Object findByKeyword(String keyword, String urlLookup) {
        object = parse(urlLookup);
        List<Object> objectList = new ArrayList<>();
        objectList.add(object);
        return objectList.stream().filter(x-> x.toString().contains(keyword)).collect(Collectors.toList());
    }*/
}
