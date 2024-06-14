package com.take.project.controller.response;

import com.take.project.model.Bucket;
import lombok.Data;

import java.util.List;

@Data
public class BucketResponse {


    private List<Bucket> bucketList;
    private double priceAll;

    public BucketResponse(List<Bucket> items){

        for(Bucket b:items){
            priceAll =  priceAll + b.getPrice();
        }

        this.bucketList = items;
    }

}
