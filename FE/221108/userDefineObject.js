let obj = {
  name: "RHCP",
  title: "Eddie",
  album: "Return of the dream canteen",
  disp: function () {
    return this.name + ": " + this.title + ": " + this.album;
  },
};

// 속성 추가 및 수정
obj.country = "USA";
obj.title = "The Drummer";

// 속성 삭제
delete obj.album;
console.log(obj);
