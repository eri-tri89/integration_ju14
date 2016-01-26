package se.ju14.scrumboard.mapper;

import java.lang.reflect.Type;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;

import se.ju14.scrumboard.model.Member;
import se.ju14.scrumboard.model.MemberStatus;

public final class MemberAdapter implements JsonSerializer<Member>, JsonDeserializer<Member> {

	// JsonSerializer
	@Override
	public JsonElement serialize(Member member, Type typeOfSrc, JsonSerializationContext context) {

		JsonObject json = new JsonObject();
		//json.addProperty("id", member.getId());
		json.addProperty("memberId", member.getMemberId());
		json.addProperty("firstName", member.getFirstName());
		json.addProperty("lastName", member.getLastName());
		json.addProperty("userName", member.getUserName());
		json.addProperty("memberStatus", member.getUserStatus().toString());
		
		
		/*
		JsonArray roles = new JsonArray();
		
		user.getRoles().forEach(r -> {
			JsonObject role = new JsonObject();
			role.addProperty("name", r.getName());
			role.addProperty("code", r.getCode());
			roles.add(role);
		})
		;
		json.add("roles", roles);
		 */
		
		return json;
	}

	// JsonDeserializer
	@Override
	public Member deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {

		JsonObject userJson = json.getAsJsonObject();
		// Long id = userJson.get("id").getAsLong();
		String memberId = userJson.get("memberId").getAsString();
		String firstName = userJson.get("firstName").getAsString();
		String lastName = userJson.get("lastName").getAsString();	
		String userName = userJson.get("userName").getAsString();	
		String memberStatusAsString = userJson.get("memberStatus").getAsString();
		MemberStatus memberStatus = MemberStatus.valueOf(memberStatusAsString);
		/*
		List<Role> roles = new ArrayList<>();

		JsonArray rolesJson = userJson.get("roles").getAsJsonArray();
		rolesJson.forEach(e -> {
			JsonObject jsonRole = e.getAsJsonObject();
			String name = jsonRole.get("name").getAsString();
			Integer code = jsonRole.get("code").getAsInt();

			roles.add(new Role(name, code));
		});
		 */
		
		return new Member(memberId,firstName,lastName,userName,memberStatus);
		
	}
}
