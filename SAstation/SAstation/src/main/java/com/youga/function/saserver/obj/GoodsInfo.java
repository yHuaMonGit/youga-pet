package com.youga.function.saserver.obj;

public class GoodsInfo {

    public  String _goosPic;
    public  String _goosName;
    public int _goosNum;
    public int _goosPrice;
    public  String _goosIndroduce;
    public int _goosPrePrice;

    public GoodsInfo(String goodsName, int goodsPrice, int goodsNum, String goodsDes, String goodsPic, int goodsPrePrice) {

        this.set_goosName(goodsName);
        this.set_goosPrice(goodsPrice);
        this.set_goosPic(goodsPic);
        this.set_goosNum(goodsNum);
        this.set_goosIndroduce(goodsDes);
        this.set_goosPrePrice(goodsPrePrice);

    }

    public int get_goosPrePrice() {
        return _goosPrePrice;
    }

    public void set_goosPrePrice(int _goosPrePrice) {
        this._goosPrePrice = _goosPrePrice;
    }

    public String get_goosPic() {
        return _goosPic;
    }

    public void set_goosPic(String _goosPic) {
        this._goosPic = _goosPic;
    }

    public  String get_goosName() {
        return _goosName;
    }

    public  void set_goosName(String _goosName) {
        this._goosName = _goosName;
    }

    public int get_goosNum() {
        return _goosNum;
    }

    public  void set_goosNum(int _goosNum) {
        this._goosNum = _goosNum;
    }

    public int get_goosPrice() {
        return _goosPrice;
    }

    public  void set_goosPrice(int _goosPrice) {
        this._goosPrice = _goosPrice;
    }

    public  String get_goosIndroduce() {
        return _goosIndroduce;
    }

    public  void set_goosIndroduce(String _goosIndroduce) {
        this._goosIndroduce = _goosIndroduce;
    }
}
