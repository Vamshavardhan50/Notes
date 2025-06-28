import mongoose from "mongoose";

const movieSchema = new mongoose.Schema({
  name: { type: String, required: true, trim: true },
  ratings: { type: Number, required: true, min: 1, max: 5 },
  money: {
    type: mongoose.Decimal128,
    required: true,
    validate: (v) => v > 10,
  },
  genre: {
    type: Array,
  },
  isActive: {
    type: Boolean,
  },
  comments: [
    { value: { type: String }, publishedAt: { type: Date, default: Date.now } },
  ],
});



const MovieModel= mongoose.model("Movie", movieSchema);



const createDoc = async()=>{
  const m1 = new MovieModel({
    name: "Inception",
    ratings: 4.8,
    money: 1000000.50,
    genre: ["Sci-Fi", "Thriller"],
    isActive: true,
    comments: [
      { value: "Amazing movie!", publishedAt: new Date() },
      { value: "Mind-blowing!", publishedAt: new Date() },
    ],
  });

  try {
    const result = await m1.save();
    // console.log("Movie created:", result);
  } catch (error) {
    console.error("Error creating movie:", error);
  }
}

const alldocs = async()=>{
  const allMovies = await MovieModel.find();
  console.log(allMovies);
}

export {alldocs, createDoc, MovieModel};